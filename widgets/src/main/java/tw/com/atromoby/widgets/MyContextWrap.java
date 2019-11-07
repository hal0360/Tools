package tw.com.atromoby.widgets;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;

import java.util.Locale;

public class MyContextWrap extends android.content.ContextWrapper {

    public MyContextWrap(Context base) {
        super(base);
    }


    public static MyContextWrap wrap(Context context, Locale newLocale) {

        Resources res = context.getResources();
        Configuration configuration = res.getConfiguration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            configuration.setLocale(newLocale);

            LocaleList localeList = new LocaleList(newLocale);
            LocaleList.setDefault(localeList);
            configuration.setLocales(localeList);

            context = context.createConfigurationContext(configuration);

        } else {
            configuration.setLocale(newLocale);
            context = context.createConfigurationContext(configuration);

        }

        return new MyContextWrap(context);
    }
}