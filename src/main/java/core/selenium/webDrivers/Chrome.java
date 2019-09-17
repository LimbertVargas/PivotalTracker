/*
 * @(#) Chrome.java Copyright (c) 2019 Jala Foundation .
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Jala
 * Foundation, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package core.selenium.webDrivers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Chrome class.
 *
 * @author Cristian Lujan
 * @version 1.0
 */
public class Chrome implements IDriver {

    /**
     * Initializes Chrome driver.
     *
     * @return A new ChromeDriver.
     */
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance().version("76.0.3809.126").setup();
        return new ChromeDriver();
    }
}
