//: 21 Jan 2021 21:29
/*
Reworking EventStream from sc-hacks.
Maybe this does not have to be a Stream.  We shall see later.
*/
EventStream /* : Stream */ { // TODO: review subclassing from Stream.
	classvar >defaultParent;

	var <clock, <quant;
	var <streamPlayer;
	
	*new { | event, parent, tempoClock, quant |
		^super.newCopyArgs(tempoClock, quant).init(event, parent);
	}

	*defaultParent {
		^defaultParent ?? { defaultParent = Event.default.parent.copy };
	}

	init { | argEvent, argParent |
		streamPlayer = SimpleEventStreamPlayer(this, argEvent, argParent, clock, quant);
		CmdPeriod add: { streamPlayer.cmdPeriod }
	}

	reset { this.resetStream }
	resetStream { streamPlayer.history.reset; }

	next { ^streamPlayer.next }

	start { this.play }
	play { streamPlayer.play; }

	stop { streamPlayer.stop }
}