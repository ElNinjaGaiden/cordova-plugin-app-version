# Cordova AppVersion plugin

Reads the version of your app from the target build settings.

## Installation

### With cordova-cli

If you are using [cordova-cli](https://github.com/apache/cordova-cli), install
with:

    cordova plugin add https://github.com/elninjagaiden/cordova-plugin-app-version.git

### With plugman

With a plain [plugman](https://github.com/apache/cordova-plugman), you should be
able to install with something like:

    plugman --platform <ios|android> --project <directory> --plugin https://github.com/elninjagaiden/cordova-plugin-app-version.git

### Manually in iOS

TODO: Write these instructions

### Manually in Android

TODO: Write these instructions

## Use from Javascript

If you are using jQuery, use:

    cordova.getAppVersion().then(function (info) {
        $('.version').text(info.version);
        $('.build').text(info.build);
    });

If not:

    cordova.getAppVersion(function (info) {
        console.log(info.version, info.build);
    });

## Credits

Written by [Robert (Jamie) Munro](http://twitter.com/rjmunro) at
[White October](http://whiteoctober.co.uk/)

Code based on the following Stack Overflow posts:

* [iOS](http://stackoverflow.com/a/14713364/3408)
* [Android](http://stackoverflow.com/a/3637686/3408)
