# Builder Pattern Eclipse Plugin

This project is a Eclipse plugin that automates the writing of these builders. With just two clicks you can generate all the builder code you need.

## About
The Builder Pattern was first introduced by Joshua Bloch at JavaOne 2007. It's a pattern for class creation and helps getting rid of ugly constructors, constructor telescoping and increases the general readability of your code.

Fork of the bpep plugin. Original source: https://github.com/henningjensen/bpep

## Use
In the eclipse java editor window, right click and select Source -> Generate Builder Pattern Code or Ctrl + Alt + P.

![screenshot](https://raw.github.com/tlcsdm/eclipse-bpep/master/plugins/com.tlcsdm.eclipse.bpep/images/usage-context-menu-option.jpg)

Then select which fields you want to expose in the builder.

![screenshot](https://raw.github.com/tlcsdm/eclipse-bpep/master/plugins/com.tlcsdm.eclipse.bpep/images/usage-selection-window.jpg)

## Build

This project uses [Tycho](https://github.com/eclipse-tycho/tycho) with [Maven](https://maven.apache.org/) to build. It requires Maven 3.9.0 or higher version.

Dev build:

```
mvn clean verify
```

Release build:

```
mvn clean org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=2.0.0 verify
```

## Install

1. Add `https://raw.githubusercontent.com/tlcsdm/eclipse-bpep/master/update_site/` as the upgrade location in Eclipse.
2. Download from [Jenkins](https://jenkins.tlcsdm.com/job/eclipse-plugin/job/eclipse-bpep)
3. <table style="border: none;">
  <tbody>
    <tr style="border:none;">
      <td style="vertical-align: middle; padding-top: 10px; border: none;">
        <a href='http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=7009215' title='Drag and drop into a running Eclipse Indigo workspace to install eclipse-bpep'> 
          <img src='https://marketplace.eclipse.org/modules/custom/eclipsefdn/eclipsefdn_marketplace/images/btn-install.svg'/>
        </a>
      </td>
      <td style="vertical-align: middle; text-align: left; border: none;">
        ← Drag it to your eclipse workbench to install! (I recommand Main Toolbar as Drop Target)
      </td>
    </tr>
  </tbody>
</table>
