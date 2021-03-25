package FrameWork.Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShooter {
    private static final String FOLDER_PATH = "D:\\Plamen\\QA\\Bin\\TestingScreenshots\\";

    public static BufferedImage takePageScreenshot(WebDriver dr, String screenshotName) throws IOException {
        File screenshot = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(FOLDER_PATH + getFileNameWithCurrentDate(screenshotName)));
        } catch (IOException excep) {
            Log.error(excep.getMessage());
            throw excep;
        }
        BufferedImage image = ImageIO.read(screenshot);
        return image;
    }

    public static BufferedImage takeWebElementScreenShot(WebElement element, String elementName)throws IOException {
        File file = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(FOLDER_PATH + getFileNameWithCurrentDate(elementName)));
        } catch (IOException excep) {
            Log.error(excep.getMessage());
            throw excep;
        }
        BufferedImage image = ImageIO.read(file);
        return image;
    }

    public static boolean compareImages(BufferedImage image1, BufferedImage image2) {
        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(image1, image2);
        if(diff.hasDiff() == true){
            System.out.println("Images are Not same");
            return false;
        }
            System.out.println("Images are same");
            return true;
    }

    private static String getFileNameWithCurrentDate(String screenshotName) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        String fileName = screenshotName + formatter.format(date).toString() + ".png";
        return fileName;
    }

}