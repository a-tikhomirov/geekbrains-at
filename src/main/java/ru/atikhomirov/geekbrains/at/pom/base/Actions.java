package ru.atikhomirov.geekbrains.at.pom.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public abstract class Actions {
    protected SelenideElement waitClickable(SelenideElement element) {
        Condition clickable = Condition.and("can be clicked", Condition.visible, Condition.enabled);
        return element.waitUntil(clickable, 5000);
    }

    protected SelenideElement getElementFromCollection(ElementsCollection collection, Condition condition) {
        return collection.findBy(condition);
    }

    protected void setCheckBoxes(ElementsCollection checkBoxes, boolean state, String... names) {

        for (String checkboxName : names) {
            SelenideElement checkBox = getElementFromCollection(checkBoxes, Condition.text(checkboxName));
            waitClickable(checkBox).find(By.className("js-checkbox"));
            if (checkBox.isSelected() != state) checkBox.click();
        }
    }
}
