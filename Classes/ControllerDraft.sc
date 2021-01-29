/* 29 Jan 2021 11:48
Draft. Replaced by Notifier (see class definition in separate file).
*/

Controller : Event {

	var <notifier, <listener, <message ;
	
	update { | sender, message ... args |
		// postf("yes %, I work. %\n", this, args);
		this[message].(sender, this, *args);
	}
	
	onRemove { | action |
		this.put(\remove, { | ... args |
			args.postln;
		});
	}
}

+ Object {
	addController { | keysValues |
		// trying approach without SimpleController
		this.addDependant(keysValues.asController);
	}
	
}

+ Event {
	asController {
		var c;
		c = Controller();
		this keysValuesDo: { | key, value | c[key] = value };
		^c;
	}
}
