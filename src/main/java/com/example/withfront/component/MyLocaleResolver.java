//package com.zhanshen.springbootweb.component;
//
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.i18n.CookieLocaleResolver;
//import org.springframework.web.servlet.i18n.SessionLocaleResolver;
//import org.thymeleaf.util.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Locale;
//
//public class MyLocaleResolver extends SessionLocaleResolver {
//    @Override
//    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
//        // Получаем значение l
//        String l = httpServletRequest.getParameter("l");
//
//        // Получить объект локали getDefault - получить системное значение по умолчанию
//        Locale locale = Locale.getDefault();
//
//        // Проверяем, пусто ли значение l
//        if(!StringUtils.isEmpty(l)) {
//            // en_US означает, что язык - английский, а регион - США. Мы разделяем эти два параметра и передаем их в Locale.
//            String[] s = l.split("_");
//            locale = new Locale(s[0], s[1]);
//        }
//        return locale;
//    }
//
//    @Override
//    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
//
//    }
//}
