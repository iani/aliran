/* 29 Jan 2021 19:47
Testing parent event types.
*/
a = (dur: 10, amp: 1, degree: 10);
a.play;
a.parent;
a.parent.keys.asArray.sort do: _.postln;
a.parent.play = { Synth(~instrument, [freq: ~freq.value.postln]) };