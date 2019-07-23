package com.mygdx.game.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.google.gwt.user.client.Window;
import com.mygdx.game.MainGame;
import com.mygdx.game.MyGdxGame;

public class HtmlLauncher extends GwtApplication {

        /** 窗口宽度参考值 */
        public static final float PIX_WIDTH = 320;

        /** 窗口宽高比, 适当调节宽高比可以查看在不同屏幕上的效果, 例如设置为 9:16, 3:4, 2:3 */
        public static final float RATIO = 9.0F / 16.0F;

        /** 适当改变缩放比以适应自己的电脑屏幕 */
        public static final float SCALE = 1.0F;

        // USE THIS CODE FOR A FIXED SIZE APPLICATION
        @Override
        public GwtApplicationConfiguration getConfig () {
                int width = width = (int) (PIX_WIDTH * SCALE);
                int height = (int) ((PIX_WIDTH / RATIO) * SCALE);

                if (Window.Navigator.getUserAgent().contains("Mobile")){
                        width = Window.getClientWidth();
                        height = Window.getClientHeight();
                }
                Window.setMargin("0px");
                Window.setTitle("Game2048");
                return new GwtApplicationConfiguration(width, height);
        }
        // END CODE FOR FIXED SIZE APPLICATION

        // UNCOMMENT THIS CODE FOR A RESIZABLE APPLICATION
        // PADDING is to avoid scrolling in iframes, set to 20 if you have problems
        // private static final int PADDING = 0;
        // private GwtApplicationConfiguration cfg;
        //
        // @Override
        // public GwtApplicationConfiguration getConfig() {
        //     int w = Window.getClientWidth() - PADDING;
        //     int h = Window.getClientHeight() - PADDING;
        //     cfg = new GwtApplicationConfiguration(w, h);
        //     Window.enableScrolling(false);
        //     Window.setMargin("0");
        //     Window.addResizeHandler(new ResizeListener());
        //     cfg.preferFlash = false;
        //     return cfg;
        // }
        //
        // class ResizeListener implements ResizeHandler {
        //     @Override
        //     public void onResize(ResizeEvent event) {
        //         int width = event.getWidth() - PADDING;
        //         int height = event.getHeight() - PADDING;
        //         getRootPanel().setWidth("" + width + "px");
        //         getRootPanel().setHeight("" + height + "px");
        //         getApplicationListener().resize(width, height);
        //         Gdx.graphics.setWindowedMode(width, height);
        //     }
        // }
        // END OF CODE FOR RESIZABLE APPLICATION

        @Override
        public ApplicationListener createApplicationListener () {
                return new MainGame();
        }
}