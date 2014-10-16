#import "AppVersion.h"
#import <Cordova/CDVPluginResult.h>

@implementation AppVersion

- (void)getVersionNumber:(CDVInvokedUrlCommand*)command
{
    //Get the application info
    NSDictionary* appBundleDictionary = [[NSBundle mainBundle] infoDictionary];
    NSString* version = [appBundleDictionary objectForKey:@"CFBundleShortVersionString"];
    NSString* build = [appBundleDictionary objectForKey:@"CFBundleVersion"];
    
    //Create the json response object
    NSDictionary* jsonObj = [ [NSDictionary alloc]
                             initWithObjectsAndKeys :
                             version, @"version",
                             build, @"build",
                             nil
                             ];
    
    //Create the response
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:jsonObj];
    
    //Send the response
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
