package com.example;

import android.app.Application;
import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

/**
 * User: Freewind
 * Date: 12-11-27
 * Time: 下午9:37
 */
@ReportsCrashes(
        //formKey = "dFhXOWt6RzBTQmtkRk40a3JmdE92RHc6MQ",
        formKey = "",
        formUri = "http://somewhere.com",
//        formUriBasicAuthLogin = "yourlogin", // optional
//        formUriBasicAuthPassword = "y0uRpa$$w0rd", // optional
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_toast_text // optional, displayed as soon as the crash occurs, before collecting data which can take a few seconds
//        resDialogText = R.string.crash_dialog_text,
//        resDialogIcon = android.R.drawable.ic_dialog_info, //optional. default is a warning sign
//        resDialogTitle = R.string.crash_dialog_title, // optional. default is your application name
//        resDialogCommentPrompt = R.string.crash_dialog_comment_prompt, // optional. when defined, adds a user text field input with this text resource as a label
//        resDialogOkToast = R.string.crash_dialog_ok_toast // optional. displays a Toast message when the user accepts to send a report.
)
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        ACRA.init(this);
        super.onCreate();
    }

}
