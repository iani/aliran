/* 29 Jan 2021 11:49
Replacing Notification class.
*/

Notifier {
	var <notifier, <message, <listener, <action;

	*new { | notifier, message, listener, action |
		^super.newCopyArgs(notifier, message, listener, action);
	}

	 // store self in library
	store { Library.put(notifier, message, listener, this) }

	*get { | notifier, message, listener | ^Library.at(notifier, message, listener) }

	*remove { | notifier, message, listener |		
		Library.put(notifier, message, listener, nil);
	}

	// respond to changed messages. Note: 'this' contains notifier and listener
	update { | sender, message ... args | action.(this, *args); }	
}

+ Object {
	addNotifier { | notifier, message, action |
		notifier.removeDependant(Notifier.get(notifier, message, this));
		notifier.addDependant(Notifier(notifier, message, this, action).store);
	}

	removeNotifier { | notifier, message |
		notifier.removeDependant(Notifier.get(notifier, message, this));
		Notifier.remove(notifier, message, this);
	}

	addNotifierOneShot { | notifier, message, action |
		this.addNotifier(notifier, message, { | notification ... args |
			action.(notification, *args);
			this.removeNotifier(notifier, message);
		})
	}

	removeMessage { | message |
		// remove all listeners listening to me at this message
		
	}

	removeListeners { // remove all listeners
	}
}
