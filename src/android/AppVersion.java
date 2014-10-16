package uk.co.whiteoctober.cordova;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.PackageInfo;

public class AppVersion extends CordovaPlugin {
	@Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
        PluginResult pluginResult = null;
        JSONObject json = new JSONObject();
        
        try {
            PackageManager packageManager = this.cordova.getActivity().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(this.cordova.getActivity().getPackageName(), 0);
            
            json.put("version", packageInfo.versionName);
            json.put("build", packageInfo.versionCode);
            pluginResult = new PluginResult(PluginResult.Status.OK, json);
            
        } catch (Exception e) {
            json.put("message", e.getMessage());
            pluginResult = new PluginResult(PluginResult.Status.ERROR, json);
        }
        
        callbackContext.sendPluginResult(pluginResult);
        return true;
    }
}
