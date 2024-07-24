package com.pak.redplm.dto;

public class EnumUtil {

    public static String formatEnumName(String name) {
        // Разделяем имя по символу '_', если он присутствует
        String[] words = name.toLowerCase().split("_");

        // Форматируем каждое слово: первая буква заглавная, остальные строчные
        StringBuilder formattedName = new StringBuilder();
        for (String word : words) {
            if (formattedName.length() > 0) {
                formattedName.append(" ");
            }
            formattedName.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1));
        }

        return formattedName.toString();
    }
}