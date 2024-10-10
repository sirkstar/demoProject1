package com.practice.pages;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SelectPageLMS {

	private WebDriver driver;
	
	@FindBy(id="single-select")
	private WebElement singleSelectDropDown;
	
	@FindBy(id="multi-select")
	private WebElement multiSelectDropDown;
	
	
	public SelectPageLMS(WebDriver ldriver) {
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	
	private Select getSingleSelect() {
//	Select select = new Select(singleSelectDropDown);
		return new Select(singleSelectDropDown);
	}
	
	private Select getMultiSelect() {
		return new Select(multiSelectDropDown);
	}
	
	public void selectSingleByIndex(int index) {
		getSingleSelect().selectByIndex(index);
	}
	
	public void selectByValueSingleSelect(String value) {
		getSingleSelect().selectByValue(value);
	}
	
	public void selectByVisibleText(String visibleText) {
		getSingleSelect().selectByVisibleText(visibleText);
	}
	
	public String getSelectedSinlgeSelect() {
		return getSingleSelect().getFirstSelectedOption().getText();
	}
	
	public void multipleSelectByIndex(List<Integer> indices) {
		Select multiSelect = getMultiSelect();
		for(int index:indices) {
			multiSelect.selectByIndex(index);
		}
	}
	
	public void multipleSelectByValue(List<String> values) {
		Select multiSelect = getMultiSelect();
		for(String value: values) {
			multiSelect.selectByValue(value);
		}
	}
	
	public void multiSelectByVisibleText(List<String> texts) {
		Select multiSelect = getMultiSelect();
		for(String text: texts) {
		multiSelect.selectByVisibleText(text);
		}
	}
	
	public List<String> getAllOptions1(){
		List<WebElement> options = getMultiSelect().getOptions();
		return options.stream()
				.map(WebElement::getText)
				.collect(Collectors.toList());
	}
	
	//deselect
	
	public void deselectByIndexSingleSelect(int index) {
		getSingleSelect().deselectByIndex(index);
	}
	
	public void deselectAllMultiSelect() {
		getMultiSelect().deselectAll();
	}
	
}
