# Pixel Sorter

Pixel sorter is an application that allows you to sort the pixels of a picture. Pixel sorting is a technique 
to create "glitch art". This specific pixel sorting application will isolate a given picture in to rows of 
pixels, and then sorts pixels by their relative luminance, calculated using the following formula:

```
Relative Luminance = 0.2126 * R + 0.7152*G + 0.0722*B

(where R, G, and B, are the Red, Green, and Blue values of the pixel's colour, respectively.)

The Luminance ranges from 0 - 255 (as it is a weighted average of the RGB value).

more about relative luminance: https://en.wikipedia.org/wiki/Relative_luminance
```

More specifically, the sorting algorithm will sort a range starting when a pixel in the row is above a certain 
threshold luminance and ending with the first pixel below a certain threshold luminance.

## Getting Started

In order to test the application for yourself, you can download the .jar, or download the source code and run the 
"ControlFrame.java" file.

[.jar file](https://drive.google.com/open?id=1B22zX42dO0FES9HIr5VqyW3nbyNcXJ-5)



### Instructions

This project is currently a work-in-progress and so you may run in to a bug while using the application. 

To open an image, click File->Open. Currently, files that are in the working directory will work with the
program.

To generate a sorted image, use the slider/number selection to set the threshold luminance (0-255) and press
generate. The best results are visible when your threshold luminance is not at the extremities, as those values
will sort very small ranges (and sorting a small range of pixels won't make a visible change).
For even better results, using objects that contrast their background will sort best due to the large difference
in luminance between the focus and the background.

### Screenshots

![Screen](http://snappyimages.nextwavesrl.netdna-cdn.com/img/edfd2c16ff27675c05314d2cd410982a.png)

### Outputs
## Sorting a picture of a dog:


Before:
![Dog Before](https://i.imgur.com/idCUlus.jpg)

After:

![Dog After](https://i.imgur.com/SbdcBoO.jpg)


##  Sorting a picture of a Waterfall:

Before:
![Waterfall Before](https://i.imgur.com/0FV0AuB.jpg)

After:

![Waterfall After](https://i.imgur.com/cf2WrKS.jpg)

## Built With

* Java

## Authors

* **Kushan Zaveri**


