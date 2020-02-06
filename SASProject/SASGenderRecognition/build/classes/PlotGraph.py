import sys
import matplotlib.pyplot as plt
import scipy.io.wavfile as wavfile
from scipy import fftpack
from scipy.fftpack import fft, fftfreq
from scipy.signal import decimate
import numpy as np
import random

X, Y = [], []

random.seed(5)

cnt = 1
myFile = open("F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataMale\\male_graph.txt", "r")
for myLine in myFile:
   X.append((random.random()) * 10)
   s = myLine
   xx = (float)(s)
   Y.append(xx)
   cnt += 1

X1, Y1 = [], []
cnt = 1

myFile = open("F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\female_graph.txt", "r")
for myLine in myFile:
   X1.append((random.random()) * 10)
   s1 = myLine
   xx1 = float(s1)
   Y1.append(xx1)
   cnt += 1

file1 = open("F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataMale\\thres_freq_male.txt","r")
s = file1.readlines()
avg_thres = (float)(s[-1])

plt.plot(0 , avg_thres, 'v', color = 'g')

file1 = open("F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\thres_freq_female.txt","r")
s = file1.readlines()
avg_thres = (float)(s[-1])

plt.plot(0 , avg_thres, 'v', color = 'm')

plt.plot(X, Y, 'o', color = 'blue')
plt.plot(X1, Y1, 'o', color = 'red')
plt.savefig('F:\Studies\Sem-3\SignalAndSystems\SAS Project\TestDataSet\\image_plot.png')
plt.show()