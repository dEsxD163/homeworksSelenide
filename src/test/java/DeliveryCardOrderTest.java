import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.open;

class DeliveryCardOrderTest {

    String generateDate (int dayToAdd) {
        return LocalDate.now().plusDays(dayToAdd).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    void deliveryCardOrderTest1() {
        String meetingDate = generateDate(3);

        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(meetingDate);
        $("[data-test-id=name] input").setValue("Заседателев Дмитрий");
        $("[data-test-id=phone] input").setValue("+79271234567");
        $("[data-test-id=agreement]").click();
        $(withText("Забронировать")).click();
        $(byText("Успешно!")).shouldBe(visible, Duration.ofMillis(15000));
    }
    @Test
    void deliveryCardOrderTest2() {
        String meetingDate = generateDate(3);

        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(meetingDate);
        $("[data-test-id=name] input").setValue("Заседателев Дмитрий");
        $("[data-test-id=phone] input").setValue("+79271234567");
        $("[data-test-id=agreement]").click();
        $(withText("Забронировать")).click();
        $(".notification__content").shouldBe(visible, Duration.ofSeconds(15));
    }

    @Test
    void deliveryCardOrderTest3() {
        String meetingDate = generateDate(5);

        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Казань");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(meetingDate);
        $("[data-test-id=name] input").setValue("Заседателев Дмитрий");
        $("[data-test-id=phone] input").setValue("+79271234567");
        $("[data-test-id=agreement]").click();
        $(withText("Забронировать")).click();
        $(".notification__content").shouldHave(text("Встреча успешно забронирована на " + meetingDate),
                Duration.ofSeconds(15)).shouldBe(visible);
    }
}