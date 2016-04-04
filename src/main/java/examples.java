import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.HHOOK;
import com.sun.jna.platform.win32.WinUser.LowLevelKeyboardProc;

public class examples {
    private static volatile boolean quit;
    private static HHOOK hhk;
    private static LowLevelKeyboardProc keyboardHook;

    public static void main(String[] args) {
        kill_application("Calculator");
    }

    private static void kill_application(String appTitle){
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow
                (null, appTitle);
        if (hwnd == null) {
            System.out.println(appTitle+" is not running");
        }
        else{
            User32.INSTANCE.PostMessage(hwnd, WinUser.WM_CLOSE, null, null);
        }
    }
}
