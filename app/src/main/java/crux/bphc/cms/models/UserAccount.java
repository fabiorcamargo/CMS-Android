package crux.bphc.cms.models;

import android.content.Context;
import android.content.SharedPreferences;

import crux.bphc.cms.models.core.UserDetail;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by harsu on 16-12-2016.
 */

public class UserAccount {

    private static final String MY_PREFS_NAME = "CMS.userAccount3";
    private final SharedPreferences prefs;

    public UserAccount(Context context) {
        prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
    }


    public boolean isLoggedIn() {
        String token = prefs.getString("token", "");
        return token != null && !token.isEmpty();
    }

    public void setUser(UserDetail userDetail) {
        prefs.edit()
                .putString("username", userDetail.getUsername())
                .putString("token", userDetail.getToken())
                .putString("firstname", userDetail.getFirstName())
                .putString("lastname", userDetail.getLastName())
                .putString("userpictureurl", userDetail.getUserPictureUrl())
                .putInt("userid", userDetail.getUserId())
                .apply();
    }

    public String getToken() {
        return prefs.getString("token", "");
    }

    public String getUsername() {
        return prefs.getString("username", "");

    }

    public String getFirstName() {
        return prefs.getString("firstname", "");

    }

    public int getUserID() {
        return prefs.getInt("userid", 0);

    }

    public void logout() {
        prefs.edit()
                .clear()
                .apply();
    }

    public boolean isNotificationsEnabled() {
        return prefs.getBoolean("notificationEnable", true);
    }

    public void setNotificationsEnabled(boolean b) {
        prefs.edit()
                .putBoolean("notificationEnable", b)
                .apply();
    }

}
