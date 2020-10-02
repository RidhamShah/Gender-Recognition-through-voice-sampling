# Gender-Recognition-through-voice-sampling
Using FFT based tools of Python and GUI tools of JAVA

## Summary

* Gender Recognition program through analyzing voice samples and data
* Menu driven GUI written in JAVA Swing JFrame tools
* The project has 2 parts: Training and testing
* For training, a real time dataset of about 100 persons was collected and put in the training program
* The main menu has opions to select data for training or testing
* The approach was to collect enough male and female audio sample data. Then using frequency analysis tools especially FFT tools available in Python, the average frequency of each audio sample was calculated through a modelling based on finding the mean frequency considering the weight/magnitude of each frequency sample in FFT output.
* Gathering multiple such average freqency values for each gender, virtual sets/gropus were made to distinguish both sexes by calculating a dynamic threshold frequency line that separates both the gender and which changes with each data sample added to the dataset.
* Once the program is trained and the threshold is calculated, test data is given. The program, based on the results of training, tries to predict the gender of the test data.
* Along with gender, the program also gives its confidence in its output(which is again modelled based on the average thresholds of male, female and the boundary separating the 2 genders).
* After prediction, the program asks the user to validate its prediction. If the user agrees to the prediction, then the program adds the new data information to that particular gender data otherwise it adds the data to the gender opposite to which the program predicted.
* Due to this, the program becomes dynamic in nature. It keeps on improving its accuracy of prediction with each test. And as a result it is expected that the confidence of the program also must increase for a large enough dataset.

## Tools and Languages

This project requires JAVA and python compiler and interpreter respectively. It uses JAVA swing classes for the GUI to interact with the user and uses Python scripts in the backend to run the frequency spectrum analysis of voice samples.

### Prerequisites

JAVA and Python


## Contributions

Contributions are welcome.

## Amendments needed
### The files recording problem :

One of the difficult problems faced while creating this project was to use a reliable Python or Java program that records the audio files fo sampling and testing and also stores it in .wav format.

We could not find such reliable tools in these languages. There are tools available that record files in .wav but the loss of information is large in them. Then there methods in which we can record in some other format and run scripts in python to convert them to .wav format. But again loss of information and possibility of addition of noise is large in them.

Also it was observed over collected dataset that more the different types of devices with different hardware and software specifications were used, more were the chances of getting high distortions in frequecny anaysis which made the prediction difficult.

Considering above challenges, the main and only recording tool used in this project is the Windows Recorder. And the recorderd files are converted to .wav format using Python script. Any suggestions to improve this shotcoings are welcome.

### The confidence equation :

The equation that shows the confidence can be made better using probailistic modelling

### Dataset :

In these type of projects, one can seldom collect large enough dataset and get 100% accuracy.

## Contributors

* **Vidish Joshi** - [Profile](https://github.com/VidishJoshi)
* **Manav Patel** - [Profile](https://github.com/PatelManav/)
* **Raj Mehta**
* **Ridham Shah** -[Profile](https://github.com/RidhamShah)

Thank you to all and any contributors.

Happy Coding!
