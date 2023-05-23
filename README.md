# Text-Readability-Score

## Get started
### Requirements

Version required on your local machine to run this project.
- Java 17
- Gradle 7.2

1. Clone the repo

```shell
git clone git@github.com:MellowPhi/text-readability-score.git
```

2. Build the project

```shell
./gradlew build
```

3. Run the project

```shell
./gradlew run
```
Note: If you would like to pass in your own text file i.e `frankenstein.txt`. Place the target text file inside
the app module. Run the `gradlew run` with `P` flag as shown below. 

```shell
./gradlew run -PfilePath=./frankenstein.txt
```

You can also import to an IDE of your choice. I recommend IntelliJ

## Usage
This project generates a readability score based 
- [Flesch–Kincaid readability](https://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests)
**Flesch-kincaid formula**
$$FKscore= 0.39 × \frac{words}{sentences} + 11.8 × \frac{syllables}{words} - 15.59$$
- [Automated readability index (ARI)](https://en.wikipedia.org/wiki/Automated_readability_index)
**Automated readability index(ARI)**
$$ARIscore= 4.71 × \frac{characters}{words} + 0.5 × \frac{words}{sentences} - 21.43$$
- [Simple Measure of Gobbledygook (SMOG index)](https://en.wikipedia.org/wiki/SMOG)
**Simple measures of Gobbledygook (SMOG) formula**
$$ARIscore= 1.043 × \sqrt{polysyllables × \frac{30}{sentences}} + 3.1291$$
- [Coleman–Liau index](https://en.wikipedia.org/wiki/Coleman%E2%80%93Liau_index)
**Coleman-Liau formula**
$$ColemanScore = 0.0588 * L - 0.296 * S - 15.8 $$
where $L = \frac{Letters}{Words} × 100$ and $S=\frac{Sentences}{Words} × 100 $



This gives an idea on how difficult a text is read.



Example output of running this program on a text file `frankenstein.txt`
```shell
The text is: 
He struggled violently. ‘Let me go,’ he cried; ‘monster! Ugly wretch! You wish to eat me and tear me to pieces. You are an ogre. Let me go, or I will tell my papa.’
‘Boy, you will never see your father again; you must come with me.’
‘Hideous monster! Let me go. My papa is a syndic—he is M. Frankenstein—he will punish you. You dare not keep me.’
‘Frankenstein! you belong then to my enemy—to him towards whom I have sworn eternal revenge; you shall be my first victim.’
The child still struggled and loaded me with epithets which carried despair to my heart; I grasped his throat to silence him, and in a moment he lay dead at my feet.

Words: 124
Sentences: 15
Characters: 516
Syllables: 159
Polysyllables: 6
Enter the score you want to calculate (ARI, FK, SMOG, CL, all):
> all
Automated Readability Index: 2.30 (about 8-year-olds).
Flesch–Kincaid readability tests: 2.76 (about 8-year-olds).
Simple Measure of Gobbledygook: 6.74 (about 12-year-olds).
Coleman–Liau index: 5.09 (about 11-year-olds).
```
