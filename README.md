# JMeter JSR223 Sample Script

This repository contains a sample script for Apache JMeter that uses JSR223 scripting (Groovy) to perform various tasks, such as generating UUIDs, formatting dates, and creating random names and addresses.

## Table of Contents

- [Introduction](#introduction)
- [Prerequisites](#prerequisites)
- [Usage](#usage)
- [Customization](#customization)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Apache JMeter is an open-source tool designed for performance testing and load testing. The JSR223 Post-Processor allows you to use scripting languages, such as Groovy, to customize the behavior of your test plan.

This repository provides sample Groovy scripts that demonstrate how to use JSR223 Post-Processor for tasks like generating UUIDs, formatting dates, and creating random names and addresses.

## Prerequisites

Before using the sample scripts, ensure you have the following:

- [Apache JMeter](https://jmeter.apache.org/) installed on your machine.
- [Bouncy Castle Library](https://www.bouncycastle.org/) added to JMeter's classpath (if using GPG encryption/decryption).
- [Groovy](https://groovy-lang.org/) scripting engine available in your JMeter installation.

## Usage

1. Copy the scripts from above example.

2. Paste the script to Jmeter's JSR223 post processon coding panel

3. Run the test plan, and observe the logs and results in the JMeter GUI or command-line interface.

## Customization

Feel free to customize the scripts based on your specific requirements. You can modify variables, add conditions, or extend the scripts for more complex scenarios. Additionally, consider incorporating external libraries or APIs for realistic data generation.

