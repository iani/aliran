/* 29 Jan 2021 17:41
Testing argTemplate in OSCFunc (for use in OSCTrig).
*/

a = { | id = 0 | SendTrig.kr(Impulse.kr(1), id) }.play;
//:
a.set(\id, 1);
//:
f = OSCFunc({ | ... args | args.postln; }, '/tr', argTemplate: [nil, 1]);
//:
f.disable;
//:
f.enable;
//:
f.remove;
//:
f.fix;