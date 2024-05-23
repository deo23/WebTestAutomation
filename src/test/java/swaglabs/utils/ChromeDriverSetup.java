package swaglabs.utils;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverSetup {

    public static void downloadAndExtractChromeDriver() throws IOException {
        String url = "https://storage.googleapis.com/chrome-for-testing-public/125.0.6422.60/win64/chromedriver-win64.zip";
        String zipFilePath = "chromedriver.zip";
        String destDir = System.getProperty("user.dir");

        // Download ChromeDriver zip file
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(zipFilePath)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        }

        // Extract ChromeDriver zip file
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                if (!entry.isDirectory()) {
                    String filePath = destDir + File.separator + entry.getName();
                    Files.createDirectories(Paths.get(filePath).getParent());
                    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
                        byte[] bytesIn = new byte[1024];
                        int read;
                        while ((read = zipInputStream.read(bytesIn)) != -1) {
                            bos.write(bytesIn, 0, read);
                        }
                    }
                }
                zipInputStream.closeEntry();
            }
        }

        // Clean up: delete the zip file
        Files.deleteIfExists(Paths.get(zipFilePath));
    }

    public static WebDriver createWebDriver() {
        String os = System.getProperty("os.name").toLowerCase();
        String driverPath = System.getProperty("user.dir");

        if (os.contains("win")) {
            driverPath += "\\chromedriver-win64\\chromedriver.exe"; // Windows path
        } else if (os.contains("mac")) {
            driverPath += "/chromedriver-mac64/chromedriver"; // Mac path
        } else if (os.contains("nix") || os.contains("nux")) {
            driverPath += "/chromedriver-linux64/chromedriver"; // Linux path
        } else {
            throw new IllegalStateException("Unsupported operating system: " + os);
        }

        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver();
    }

}
