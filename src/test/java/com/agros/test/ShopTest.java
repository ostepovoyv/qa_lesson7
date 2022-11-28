package com.agros.test;

import com.agros.test.config.TestBase;
import com.agros.test.pages.MainPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;


public class ShopTest extends TestBase {

    static Stream<Arguments> verifySidebarTest() {
        return Stream.of(
                Arguments.of("Смартфоны и гаджеты", List.of("Сотовые телефоны","Гаджеты","Программное обеспечение","Аксессуары")),
                Arguments.of("Комплектующие", List.of("Все для сборки компьютера", "Дополнительные комплектующие")),
                Arguments.of("Ноутбуки и компьютеры", List.of("Ноутбуки","Компьютеры", "Программное обеспечение", "Комплектующие для ноутбуков", "Аксессуары", "Мебель"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка бокового меню {0}")
    public void verifySidebarTest(String items, List<String> categories){
        new MainPage().verifySidebarMenu(items,categories);
    }

    @ValueSource(strings = {"Доставка", "Оплата", "Гарантия надёжности"})
    @ParameterizedTest(name = "Проверка горизонтального меню {0}")
    public void verifyHorizontalMenuTest(String items){
        new MainPage().verifyHorizontalMenu(items);
    }

    @ParameterizedTest(name = "Проверка горизонтального меню {0}")
    @CsvFileSource(resources = "/test.csv")
    public void verifyHorizontalMenuFromCscFileTest(String items){
        new MainPage().verifyHorizontalMenu(items);
    }

}
