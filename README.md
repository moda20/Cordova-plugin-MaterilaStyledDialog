# Cordova MaterialStyleDialog

**Based On :** 

Color Dialog : https://github.com/javiersantos/MaterialStyledDialogs


**Cordova plugin : Fancy Alerts** 


Platforms available : **android**


***install :***

1 ) run `cordova plugin add https://github.com/moda20/Cordova-plugin-MaterilaStyledDialog.git`

2 ) use directly from the `window` available `cordova` object.

# Usage

***Example :***

```javascript
let ARGS={
            title:'Header Dialog',
            description:'It is a header Dialog and this is a Dialog Description',
            headercolor:'#c60808', //#FFFFF
            animation:true, // or false
            scrollable :true, // or false
            cancellable: false, // or false
            buttons:
                {
                    positivetext:'Positive', // button text
                    positivereturn:'Positive', // text to be returned when clicked on positive
                    negativetext:'', // button text
                    negativereturn:'', // text to be returned when clicked on negative
                    neutraltext:'Neutral', // button text
                    neutralreturn:'Neutral' // text to be returned when clicked on neutral
                }

        }
        window.cordova.plugins.CordovaMaterialStyleDialog.ShowDialog(ARGS).then(
            function (res) {
                console.log(res);
            }
        ).catch(e=>{
            console.log(e);
            alert("Errored")
        })
```
***Docs :***
```text
The `FancyAlertPlugin` has only One method : `ShowDialog`.

CordovaMaterialStyleDialog.ShowDialog(arguments) : Promise <String>;

arguments : {
                        title:'', // dialog title : Mandatory
                        description:'', // Dialog Description : Mandatory
                        headercolor:'', //#c60808 : Mandatory
                        animation:true, // or false  activates or desactivates in and out animation : Optional : Default false
                        scrollable :true, // or false activates or desactivates the scrolling of content : Optional : Default false
                        cancellable: false, // or false activates or desactivates the cancelling by tapping outside : Optional : Default false
                        buttons:  // 3 Buttons maximum
                            {
                                positivetext:'', // button text
                                positivereturn:'', // text to be returned when clicked on positive
                                negativetext:'', // button text
                                negativereturn:'', // text to be returned when clicked on negative
                                neutraltext:'', // button text
                                neutralreturn:'' // text to be returned when clicked on neutral
                            }
            
                    }

```
```
Plugin.xml :

You may have to change the com.android.support:appcompat-v7:27.1.1 to a certain version.
Note that this version needs to be unique with all components in your app, so make sure you have it fixed.

```

# ChangeLog

   
    
# Licence 

MIT
