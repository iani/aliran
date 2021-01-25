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
//:debug Event:makeStream
().makeStream;
(dur: Pseries(1, 1, 3)).makeStream;

//:
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
//:Modifying an EventStream 
{
	
	
}.fork;