package testUtils.interaction;

import driver.DriverFactory;
import driver.Platform;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class Swipe {
    public static void swipeVertically(AppiumDriver appiumDriver, int startX, int endX, int startY, int endY) {
        // Specify PointerInput as [TOUCH] with name [finger1]
        PointerInput pointerInput = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        // Specify sequence
        Sequence sequence = new Sequence(pointerInput, 1)
                .addAction(pointerInput.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(pointerInput.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(pointerInput, Duration.ofMillis(250)))
                .addAction(pointerInput.createPointerMove(Duration.ofMillis(250), PointerInput.Origin.viewport(), endX, endY))
                .addAction(pointerInput.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        // Ask appium server to perform the sequence
        appiumDriver.perform(Collections.singleton(sequence));
    }

    public static void narrowDown(AppiumDriver appiumDriver) {
        //Swipe up before interacting
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();
        System.out.printf("%d x %d " , screenHeight, screenWidth);

        //Construct coordinators
        int startX = (50*screenWidth)/100;
        int startY = 0;
        int endX = startX;
        int endY = (50*screenHeight)/100;
        // Specify PointerInput as [TOUCH] with name [finger1]
        PointerInput pointerInput = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        // Specify sequence
        Sequence sequence = new Sequence(pointerInput, 1)
                .addAction(pointerInput.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(pointerInput.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(pointerInput, Duration.ofMillis(300)))
                .addAction(pointerInput.createPointerMove(Duration.ofMillis(250), PointerInput.Origin.viewport(), endX, endY))
                .addAction(pointerInput.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        // Ask appium server to perform the sequence
        appiumDriver.perform(Collections.singleton(sequence));
    }

    public static void narrowUp(AppiumDriver appiumDriver) {
        Dimension windowSize = appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();
        int startX = (50*screenWidth)/100;
        int startY = (80*screenHeight)/100;
        int endX = startX;
        int endY = 0;

        PointerInput pointerInput = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(pointerInput, 1)
                .addAction(pointerInput.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(pointerInput.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(pointerInput, Duration.ofMillis(300)))
                .addAction(pointerInput.createPointerMove(Duration.ofMillis(250), PointerInput.Origin.viewport(), endX, endY))
                .addAction(pointerInput.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        appiumDriver.perform(Collections.singleton(sequence));
        }
}
