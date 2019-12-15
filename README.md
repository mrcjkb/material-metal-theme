# Dark and light material design Metal themes for Swing.

## Use
The theme uses the Builder pattern for defining primary, secondary and accent colors.
See
`DarkMaterialSwingTheme.builder()`
and
`LightMaterialSwingTheme.builder()`.
The primary colour should be a grey tone for each theme.

If only primary1 is specified (the first primary color), defaults are chosen for the others, based on primary1.

Example:
`MetalLookAndFeel.setCurrentTheme(DarkMaterialSwingTheme.builder().withPrimary1(new ColorUIResource(62, 62, 62).withAccent1(new ColorUIResource(0, 120, 255)).withAccent2(new ColorUIResource(Color.GREEN)).build());`


## Libraries - Credits

### Copyright notice - material-ui-swing
Some code has been based on [material-ui-swing](https://github.com/atarw/material-ui-swing) by Atharva Washimkar.


MIT License

Copyright (c) 2017 atharva washimkar

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

### SVG Icons
The SVG icons used in this library were transcoded using Photon: https://github.com/kirill-grouchnikov/radiance/blob/master/docs/photon/photon.md