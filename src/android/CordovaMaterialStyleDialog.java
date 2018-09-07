package cordova.plugin.materialdialogs;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import android.graphics.Color;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.Boolean;
import android.support.annotation.NonNull;
import com.github.javiersantos.materialstyleddialogs.enums.Style;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
/**
 * This class echoes a string called from JavaScript.
 */


public class CordovaMaterialStyleDialog extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String title = args.getString(0);
            String desc = args.getString(1);
            String hcolor = args.getString(2);
            Boolean anim = args.getBoolean(3);
            Boolean scroll = args.getBoolean(4);
            Boolean cancel = args.getBoolean(5);
            String postxt = args.getString(6);
            String posret = args.getString(7);
            String negtxt = args.getString(8);
            String negret = args.getString(9);
            String neuttxt = args.getString(10);
            String neutret = args.getString(11);


            this.coolMethod(title, desc, hcolor, anim, scroll, cancel, postxt, posret, negtxt, negret, neuttxt, neutret, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String title, String desc, String hcolor, Boolean anim, Boolean scroll, Boolean cancel, String postxt, String posret, String negtxt, String negret, String neuttxt, String neutret, CallbackContext callbackContext) {
        if (title != null && title.length() > 0 && desc!= null && desc.length() > 0 && hcolor!= null && hcolor.length() > 0) {
       MaterialStyledDialog.Builder dialog =  new MaterialStyledDialog.Builder(cordova.getContext())
        	.setTitle(title)
        	.setDescription(desc)
        	.withDialogAnimation(anim)
        	.setHeaderColorInt(Color.parseColor(hcolor))
        	.setStyle(Style.HEADER_WITH_TITLE);
        	if(postxt != null && postxt.length() >0){
        	    dialog.setPositiveText(postxt);
        	    dialog.onPositive(new MaterialDialog.SingleButtonCallback() {
                      @Override
                      public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                          callbackContext.success(posret);
                      }
                  });
        	}
        	if(negtxt != null && negtxt.length() >0){
                dialog.setNegativeText(negtxt);
                dialog.onNegative(new MaterialDialog.SingleButtonCallback() {
                      @Override
                      public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                          callbackContext.success(negret);
                      }
                  });
            }

            if(neuttxt != null && neuttxt.length() >0){
                dialog.setPositiveText(neuttxt);
                dialog.onPositive(new MaterialDialog.SingleButtonCallback() {
                      @Override
                      public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                          callbackContext.success(neutret);
                      }
                  });
            }

        	dialog.show();

        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
