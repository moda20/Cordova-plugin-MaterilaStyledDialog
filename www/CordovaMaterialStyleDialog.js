var exec = require('cordova/exec');

/*
exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'CordovaMaterialStyleDialog', 'coolMethod', [arg0]);
};

*/

/*let ARGS={
    title:'',
    description:'',
    headercolor:'', //#FFFFF
    animation:true, // or false
    scrollable :true, // or false
    cancellable: true, // or false
    buttons:
        {
            positivetext:'', // button text
            positivereturn:'', // text to be returned when clicked on positive
            negativetext:'', // button text
            negativereturn:'', // text to be returned when clicked on negative
            neutraltext:'', // button text
            neutralreturn:'' // text to be returned when clicked on neutral
        }

}*/


exports.ShowDialog = function (arg0) {
    let arg =[arg0.title,arg0.description,arg0.headercolor,arg0.animation,
    arg0.scrollable,arg0.cancellable];

        arg0.buttons.positivetext?arg.push(arg0.buttons.positivetext):arg.push('');
        arg0.buttons.positivereturn?arg.push(arg0.buttons.positivereturn):arg.push('positive');


        arg0.buttons.negativetext?arg.push(arg0.buttons.negativetext):arg.push('');
        arg0.buttons.negativereturn?arg.push(arg0.buttons.negativereturn):arg.push('negative');


        arg0.buttons.neutraltext?arg.push(arg0.buttons.neutraltext):arg.push('');
        arg0.buttons.neutralreturn?arg.push(arg0.buttons.neutralreturn):arg.push('neutral');


    return new Promise((res,rej)=>{
        exec((suc)=>{res(suc)}, (err)=>{rej(err)}, 'CordovaMaterialStyleDialog', 'coolMethod', arg);
    })

};