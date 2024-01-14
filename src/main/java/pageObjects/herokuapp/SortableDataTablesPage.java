package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.baseObjects.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortableDataTablesPage extends BasePage {

    private final By header = By.tagName("h3");
    private final By cell = By.tagName("td");

    public void verifyTitleText() {
        waitUntilTextToBe(header,"Data Tables");
    }

    private WebElement getTable(Integer tableIndex) {
        return driver.findElement(By.id("table" + tableIndex));
    }

    private List<WebElement> getHeaders(Integer tableIndex) {
        return getTable(tableIndex).findElements(By.tagName("th"));
    }

    private List<WebElement> getTableRows(Integer tableIndex) {
        return getTable(tableIndex).findElements(By.xpath("//tbody//tr"));
    }

    private Integer getAmountOfColumns(Integer tableIndex) {
        return getHeaders(tableIndex).size();
    }

    private Integer getAmountOfRows(Integer tableIndex) {
        return getTableRows(tableIndex).size();
    }

    private List<WebElement> getTableCells(Integer tableIndex) {
        return getTable(tableIndex).findElements(cell);
    }

    public List<String> getConvertedEmails(Integer tableIndex) {
        return getTableCellsData(1).stream()
                .filter(email->email.contains("@"))
                .map(email->email.replaceAll("@[a-zA-Z.]+", "@gmail.com"))
                .collect(Collectors.toList());
    }

    public List<String> getTableHeaders(Integer tableIndex) {
        return getHeaders(tableIndex).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getTableRowData(Integer tableIndex, Integer tableRowIndex) {
        return getTableRows(tableIndex).get(tableRowIndex - 1).findElements(cell).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getTableCellsData(Integer tableIndex) {
        return getTableCells(tableIndex).stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
