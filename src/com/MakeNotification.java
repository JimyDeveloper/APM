
package com;

import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;


public class MakeNotification {
    
   
    public static void makeNotification(String title){
        Notifications not=Notifications.create().title(title)
               .graphic(null).hideAfter(Duration.seconds(5)).position(Pos.TOP_LEFT).onAction(ev->{
                   System.out.println("Correct");
                   
        });
         not.showConfirm();
    }
}
