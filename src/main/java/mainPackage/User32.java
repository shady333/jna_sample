package mainPackage;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public interface User32 extends StdCallLibrary{
    public static final User32 INSTANCE = (User32)Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);

    WinDef.HWND GetDlgItem(WinDef.HWND hWnd, int itemId);

    int GetDlgCtrlID(WinDef.HWND hWnd);

    int SendMessage(Pointer hWnd, int msg, int num1, int num2);

    int SendMessageA(Pointer hWnd, int msg, int num1, int num2);

    int SendMessageW(Pointer hWnd, int msg, int num1, int num2);

    public abstract WinDef.HDC GetDC(WinDef.HWND paramHWND);

    public abstract int ReleaseDC(WinDef.HWND paramHWND, WinDef.HDC paramHDC);

    public abstract WinDef.HWND FindWindow(String paramString1, String paramString2);

    public abstract int GetClassName(WinDef.HWND paramHWND, char[] paramArrayOfChar, int paramInt);

    public abstract boolean GetGUIThreadInfo(int paramInt, WinUser.GUITHREADINFO paramGUITHREADINFO);

    public abstract boolean GetWindowInfo(WinDef.HWND paramHWND, WinUser.WINDOWINFO paramWINDOWINFO);

    public abstract boolean GetWindowRect(WinDef.HWND paramHWND, WinDef.RECT paramRECT);

    public abstract int GetWindowText(WinDef.HWND paramHWND, char[] paramArrayOfChar, int paramInt);

    public abstract int GetWindowTextLength(WinDef.HWND paramHWND);

    public abstract int GetWindowModuleFileName(WinDef.HWND paramHWND, char[] paramArrayOfChar, int paramInt);

    public abstract int GetWindowThreadProcessId(WinDef.HWND paramHWND, IntByReference paramIntByReference);

    public abstract boolean EnumWindows(WinUser.WNDENUMPROC paramWNDENUMPROC, Pointer paramPointer);

    public abstract boolean EnumChildWindows(WinDef.HWND paramHWND, WinUser.WNDENUMPROC paramWNDENUMPROC, Pointer paramPointer);

    public abstract boolean EnumThreadWindows(int paramInt, WinUser.WNDENUMPROC paramWNDENUMPROC, Pointer paramPointer);

    public abstract boolean FlashWindowEx(WinUser.FLASHWINFO paramFLASHWINFO);

    public abstract WinDef.HICON LoadIcon(WinDef.HINSTANCE paramHINSTANCE, String paramString);

    public abstract WinNT.HANDLE LoadImage(WinDef.HINSTANCE paramHINSTANCE, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4);

    public abstract boolean DestroyIcon(WinDef.HICON paramHICON);

    public abstract int GetWindowLong(WinDef.HWND paramHWND, int paramInt);

    public abstract int SetWindowLong(WinDef.HWND paramHWND, int paramInt1, int paramInt2);

    public abstract Pointer SetWindowLong(WinDef.HWND paramHWND, int paramInt, Pointer paramPointer);

    public abstract BaseTSD.LONG_PTR GetWindowLongPtr(WinDef.HWND paramHWND, int paramInt);

    public abstract BaseTSD.LONG_PTR SetWindowLongPtr(WinDef.HWND paramHWND, int paramInt, BaseTSD.LONG_PTR paramLONG_PTR);

    public abstract Pointer SetWindowLongPtr(WinDef.HWND paramHWND, int paramInt, Pointer paramPointer);

    public abstract boolean SetLayeredWindowAttributes(WinDef.HWND paramHWND, int paramInt1, byte paramByte, int paramInt2);

    public abstract boolean GetLayeredWindowAttributes(WinDef.HWND paramHWND, IntByReference paramIntByReference1, ByteByReference paramByteByReference, IntByReference paramIntByReference2);

    public abstract boolean UpdateLayeredWindow(WinDef.HWND paramHWND, WinDef.HDC paramHDC1, WinUser.POINT paramPOINT1, WinUser.SIZE paramSIZE, WinDef.HDC paramHDC2, WinUser.POINT paramPOINT2, int paramInt1, WinUser.BLENDFUNCTION paramBLENDFUNCTION, int paramInt2);

    public abstract int SetWindowRgn(WinDef.HWND paramHWND, WinDef.HRGN paramHRGN, boolean paramBoolean);

    public abstract boolean GetKeyboardState(byte[] paramArrayOfByte);

    public abstract short GetAsyncKeyState(int paramInt);

    public abstract WinUser.HHOOK SetWindowsHookEx(int paramInt1, WinUser.HOOKPROC paramHOOKPROC, WinDef.HINSTANCE paramHINSTANCE, int paramInt2);

    public abstract WinDef.LRESULT CallNextHookEx(WinUser.HHOOK paramHHOOK, int paramInt, WinDef.WPARAM paramWPARAM, WinDef.LPARAM paramLPARAM);

    public abstract WinDef.LRESULT CallNextHookEx(WinUser.HHOOK paramHHOOK, int paramInt, WinDef.WPARAM paramWPARAM, Pointer paramPointer);

    public abstract boolean UnhookWindowsHookEx(WinUser.HHOOK paramHHOOK);

    public abstract int GetMessage(WinUser.MSG paramMSG, WinDef.HWND paramHWND, int paramInt1, int paramInt2);

    public abstract boolean PeekMessage(WinUser.MSG paramMSG, WinDef.HWND paramHWND, int paramInt1, int paramInt2, int paramInt3);

    public abstract boolean TranslateMessage(WinUser.MSG paramMSG);

    public abstract WinDef.LRESULT DispatchMessage(WinUser.MSG paramMSG);

    public abstract void PostMessage(WinDef.HWND paramHWND, int paramInt, WinDef.WPARAM paramWPARAM, WinDef.LPARAM paramLPARAM);

    public abstract void PostMessage(WinDef.HWND paramHWND, int paramInt, int paramInt1, int paramint2);

    public abstract void PostQuitMessage(int paramInt);

    public abstract int GetSystemMetrics(int paramInt);

    public WinDef.HWND FindWindowEx(WinDef.HWND hwndParent, WinDef.HWND hwndChildAfter, String lpszClass, String lpszWindow);

    public boolean LockWorkStation();

    public void mouse_event(int dwFlags, int dx, int dy, int dwData,int dwExtraInfo);
}
