package com.pie.account.util;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class I18nUtil {
    private final MessageSourceAccessor accessor;

    public I18nUtil(MessageSource messageSource) {
        accessor = new MessageSourceAccessor(messageSource, Locale.getDefault());
    }

    public String getMessage(String key){
        return  accessor.getMessage(key);
    }

}
