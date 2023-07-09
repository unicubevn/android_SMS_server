package github.umer0586.smsserver;

import android.app.Application;
import android.content.Context;

import org.acra.ACRA;
import org.acra.config.CoreConfigurationBuilder;
import org.acra.config.MailSenderConfigurationBuilder;
import org.acra.data.StringFormat;

public class App extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        ACRA.init(this, new CoreConfigurationBuilder()
                //core configuration:
                .withBuildConfigClass(BuildConfig.class)
                .withReportFormat(StringFormat.JSON)
                .withPluginConfigurations(
                        //each plugin you chose above can be configured with its builder like this:
                        new MailSenderConfigurationBuilder()
                                //required
                                .withMailTo("umerfarooq.phone@gmail.com")
                                //defaults to true
                                .withReportAsFile(true)
                                //defaults to ACRA-report.stacktrace
                                .withReportFileName("Crash.txt")
                                //defaults to "<applicationId> Crash Report"
                                .withSubject("Android SMS Server Crash Report")
                                //defaults to empty
                                .withBody("Application crash report attached")
                                .build()
                )
        );
    }

}
