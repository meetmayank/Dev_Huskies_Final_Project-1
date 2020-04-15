/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.GoogleMAP;

import static com.teamdev.jxbrowser.engine.RenderingMode.*;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.frame.internal.rpc.ExecuteJavaScriptRequest;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DistanceMap {

    private static final int MIN_ZOOM = 0;
    private static final int MAX_ZOOM = 21;
    //private static final String setMarkerScript = "var locations = [\n  ['Bondi Beach', -33.890542, 151.274856, 4],\n  ['Coogee Beach', -33.923036, 151.259052, 5],\n  ['Cronulla Beach', -34.028249, 151.157507, 3],\n  ['Manly Beach', -33.80010128657071, 151.28747820854187, 2],\n  ['Maroubra Beach', -33.950198, 151.259302, 1]\n];\n\nvar marker, i;\n\nfor (i = 0; i < locations.length; i++) {  \n  marker = new google.maps.Marker({\n\tposition: new google.maps.LatLng(locations[i][1], locations[i][2]),\n\tmap: map,\n\ttitle: locations[i][0]\n  });\n}";
    
    private static final String a = "var marker, i;\n\nfor (i = 0; i < locations.length; i++) {  \n  marker = new google.maps.Marker({\n\tposition: new google.maps.LatLng(locations[i][1], locations[i][2]),\n\tmap: map,\n\ttitle: locations[i][0]\n  });\n}";
    private static final String b = "var locations = [\n";
    private static final String c = "];\n";
    private static final String d = "['Bondi Beach', -33.890542, 151.274856, 4],\n['Coogee Beach', -33.923036, 151.259052, 5]";
    private static final String setMarkerScript = b + d + c + a;
    /**
     * In map.html file default zoom value is set to 4.
     */
    private static int zoomValue = 4;

    public static void openMap() {
        EngineOptions options =
                EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey("1BNDHFSC1FV3AVC573VVDZLJMH4GM0F2LEEC89Z3D9HIMNGKQZEH4PIJYFW22I0A9NMRRK").build();
        Engine engine = Engine.newInstance(options);
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);

            JButton zoomInButton = new JButton("Zoom In");
            zoomInButton.addActionListener(e -> {
                if (zoomValue < MAX_ZOOM) {
                    browser.mainFrame().ifPresent(frame ->
                            frame.executeJavaScript("map.setZoom(" +
                                    ++zoomValue + ")"));
                }
            });

            JButton zoomOutButton = new JButton("Zoom Out");
            zoomOutButton.addActionListener(e -> {
                if (zoomValue > MIN_ZOOM) {
                    browser.mainFrame().ifPresent(frame ->
                            frame.executeJavaScript("map.setZoom(" +
                                    --zoomValue + ")"));
                }
            });
            /*browser.mainFrame().ifPresent(frame ->
                            frame.executeJavaScript(setMarkerScript));*/
            JButton setMarkerButton = new JButton("Set Marker");
            setMarkerButton.addActionListener(e ->
                    browser.mainFrame().ifPresent(frame ->
                            frame.executeJavaScript(setMarkerScript)));
            
            /*JButton setMarkerButton = new JButton("Set Marker");
       setMarkerButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               
               browser.executeJavaScript("var myLatlng = new google.maps.LatLng(48.4431727,23.0488126);\n" +
                       "var marker = new google.maps.Marker({\n" +
                       "    position: myLatlng,\n" +
                       "    map: map,\n" +
                       "    title: 'Hello World!'\n" +
                       "});");
           }
       });*/

            JPanel toolBar = new JPanel();
            toolBar.add(zoomInButton);
            toolBar.add(zoomOutButton);
            toolBar.add(setMarkerButton);

            JFrame frame = new JFrame("Google Maps");
            frame.add(toolBar, BorderLayout.SOUTH);
            frame.add(view, BorderLayout.CENTER);
            frame.setSize(800, 500);
            frame.setVisible(true);

            //browser.navigation().loadUrl("C:\\Users\\Mayank\\Desktop\\Final Proj\\Dev_Huskies_Final_Project\\Emergency_Response_System\\map.html");
        });
    }
}
