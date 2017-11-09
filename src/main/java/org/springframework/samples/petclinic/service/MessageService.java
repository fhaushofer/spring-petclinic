package org.springframework.samples.petclinic.service;

import com.ibm.icu.text.MessageFormat;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Locale;

@Service
public class MessageService {
    @Resource
    MessageSource messageSource;

    public String getPluralalizedMessage(String key, int number) {
        Locale locale = LocaleContextHolder.getLocale();
        String pattern = messageSource.getMessage(key, null, locale);
        MessageFormat msgFormat = new MessageFormat(pattern, locale);

        return msgFormat.format(new Object[] {number});
    }

}
