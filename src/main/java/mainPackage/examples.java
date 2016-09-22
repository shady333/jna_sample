package mainPackage;

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
        CalculatorControl calc = new CalculatorControl();
        calc.init();



        calc.sendCommandToCalculator("1");
        calc.sendCommandToCalculator("+");
        calc.sendCommandToCalculator("2");
        calc.sendCommandToCalculator("=");

        calc.getResult();

//        WinDef.HWND hWnd = User32.INSTANCE.FindWindow(null, "Calculator");
//        WinDef.DWORD a = new WinDef.DWORD(5);   // child 5
//        System.out.println("parent : " + hWnd);
//        WinDef.HWND hWnd3 = User32.INSTANCE.GetWindow ( hWnd , a );
//        System.out.println("child " + hWnd3);
//        WinDef.DWORD b = new WinDef.DWORD(2);  // next 2
//        WinDef.HWND hWnd2= User32.INSTANCE.GetWindow ( hWnd3 , b );
//        System.out.println(hWnd2);
//        int x = 0;
//        while (hWnd2  != null ) {
//            x++;
//            System.out.println("hWnd: " + hWnd2.toString());
//            System.out.println("Canonical Name: "+ hWnd2.getClass().getCanonicalName());
//            System.out.println("Class Name: " + hWnd2.getClass().getName());
//            System.out.println("/**********************************/");
//            hWnd2= User32.INSTANCE.GetWindow ( hWnd , b );
//            if (x>30)
//                break;
//        }

        //kill_application("Calculator");
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
