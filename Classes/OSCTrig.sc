/* 29 Jan 2021 15:33
Trigger EventStream from SendTrig
*/

OSCTrig {
	var <id, <oscFunc, <triggered;

	*new { | id |
		^this.newCopyArgs(id).makeOscFunc;
	}

	makeOscFunc {
		oscFunc = OSCFunc({ | ... args |
			args.postln;
			this.changed(\trig, *args);
		}, '/tr', argTemplate: [id]).fix;
		
	}

	free {
		// TODO: Remove notifier dependants
		oscFunc.disable;
		
	}

}