/* 25 Jan 2021 13:16
First tests after refactoring.
*/
//:test Event:addEvent 
a = ();
("dur key before adding: " + a.dur).postln;
a addEvent: (dur: 1, degree: 10);
("dur key after adding: " + a.dur).postln;
a;
//:Event:play plays just one event
().play; // plays just one event
//:================================================================
//:Event:splay plays the event as stream
(amp: 1).splay;
//:Start and stop an EventStream;
{
	var stream;
	stream = (degree: Pseq((0..14), inf), dur: 0.25).splay;
	loop {
		0.5.rrand(1.5).wait;
		stream.stop;
		0.5.rrand(1.5).wait;
		stream.play;
	};
}.fork;
//:Modifying an EventStream while playing
~stream = (dur: 0.1).splay;
~stream add: (degree: Pwhite(-10, 0));
~stream add: (degree: Pbrown(0, 10, 2));
~stream.put(\amp, Pbrown(0, 0.1, 0.01));
~stream.put(\dur, Pbrown(0.01, 0.1, 0.01));
~stream.stop;
~stream.start;
~stream set: (dur: Prand([0.5, 0.05], inf));
//:
