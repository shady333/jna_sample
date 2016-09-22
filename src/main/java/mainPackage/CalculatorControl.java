package mainPackage;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.math.BigInteger;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;

import static com.sun.jna.platform.win32.WinUser.MOD_CONTROL;
import static com.sun.jna.platform.win32.WinUser.WM_KEYDOWN;
import static com.sun.jna.platform.win32.WinUser.WM_KEYUP;
import static java.awt.event.KeyEvent.VK_5;
import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_C;

public class CalculatorControl {
    private HWND calcWindowHandle;

    private static String calc_name = "Calc98 [Dec] [radians]";

    /**
     * User32 DLL instance
     */
    public User32 USER32INST;


    /**
     * When a number / operator is recognized the value is sent to this method, which takes
     * care of performing the whole operation and shows the result.
     * @param command Operator / Operand
     */
    public  void sendCommandToCalculator(String buttonName){

        HWND hwndChild = USER32INST.FindWindowEx((HWND)calcWindowHandle,null,"Button",buttonName);

        WinDef.WPARAM wParamValue = new WinDef.WPARAM(Long.parseLong("0"));

        WinDef.LPARAM lParamValue = new WinDef.LPARAM(Long.parseLong("0"));

        USER32INST.PostMessage(hwndChild,245, wParamValue, lParamValue);

    }

    public void getResult(){
        HWND hwndChild = USER32INST.FindWindowEx((HWND)calcWindowHandle,null,"FSICALCGENERIC", null);

        String asd = null;

        char[] d = new char[10];

        //USER32INST.G GetWindowText(hwndChild, d, 10);


        USER32INST.PostMessage(hwndChild, WM_KEYDOWN, MOD_CONTROL, VK_C);
        USER32INST.PostMessage(hwndChild, WM_KEYUP, MOD_CONTROL, VK_C);

        USER32INST.SendMessage(hwndChild.getPointer(), WM_KEYDOWN, MOD_CONTROL, VK_C);
        USER32INST.SendMessage(hwndChild.getPointer(), WM_KEYUP, MOD_CONTROL, VK_C);

        USER32INST.SendMessageA(hwndChild.getPointer(), WM_KEYDOWN, MOD_CONTROL, VK_C);
        USER32INST.SendMessageA(hwndChild.getPointer(), WM_KEYUP, MOD_CONTROL, VK_C);

        USER32INST.SendMessageW(hwndChild.getPointer(), WM_KEYDOWN, MOD_CONTROL, VK_C);
        USER32INST.SendMessageW(hwndChild.getPointer(), WM_KEYUP, MOD_CONTROL, VK_C);

        String a = getClipboardContents();
//        USER32INST.PostMessage(hwndChild, WM_KEYUP, VK_5, 0);

    }

    public String getClipboardContents() {
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        //odd: the Object param of getContents is not currently used
        Transferable contents = clipboard.getContents(null);
        boolean hasTransferableText =
                (contents != null) &&
                        contents.isDataFlavorSupported(DataFlavor.stringFlavor)
                ;
        if (hasTransferableText) {
            try {
                result = (String)contents.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return result;
    }

    public static boolean isHex(String hex) {
        try {
            new BigInteger(hex, 16);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void init() {

        USER32INST = User32.INSTANCE;

        calcWindowHandle = USER32INST.FindWindow(null,calc_name);

        if(calcWindowHandle != null){
            System.out.println("CALCULATOR is running.");
            return;
        }
        else{
            System.out.println("CALCULATOR is not running.");
            System.out.println("Strating the CALCULATOR.");

            try {
                Runtime.getRuntime().exec("D:\\Calc98\\CALC.EXE");
                Thread.sleep(5000);
            } catch (IOException e) {
                System.out.println("Internal Error. CALCULATOR cannot be started.");
                e.printStackTrace();
                return;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            calcWindowHandle = USER32INST.FindWindow(null,calc_name);

            return;
        }

    }
}
