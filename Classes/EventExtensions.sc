/* 25 Jan 2021 10:29
Some useful event methods
*/
+ Event {
	splay { | quant, clock |
		^EventStream(this).play()	
	}

	makeStream { | argParent |
		var copy;
		copy = ().parent = argParent.asParent;
		this keysValuesDo: { | key, value |
			copy[key] = value.asStream;
		};
		^copy;
	}

	makeNext { | argParent |
		var outValue, nextEvent;
		nextEvent = ();
		nextEvent.parent = parent;
		sourceEvent keysValuesDo: { | key, value |
			outValue = value.next(this);
			if (outValue.isNil) { ^nextEvent = nil };
			nextEvent[key] = outValue;
		};
		^nextEvent;		
	}
	asParent { ^this.copy }
}

+ Nil {
	asParent { ^EventStream.defaultParent.asParent }
	
}