import sys
import matplotlib.pyplot as plt
import scipy.io.wavfile as wavfile
from scipy import fftpack
from scipy.fftpack import fft, fftfreq
from scipy.signal import decimate
import numpy as np


file1 = open("F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\avg_thres_female.txt","r+")
s = file1.readlines()
avg_thres = (float)(s[-1])
file1.close()

file1 = open("F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\total_num_of_data_female.txt","r+")
s = file1.readlines()
total_files = (int)(s[0])
file1.close()

avg_thres = avg_thres + (float)(sys.argv[1])
total_files = total_files + 1

thres_freq = avg_thres / total_files

f = open('F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\avg_thres_female.txt', 'w+')
f.write((str)(avg_thres))
f.close()


#write sigma(fi)
f = open('F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\total_num_of_data_female.txt', 'w+')
f.write((str)(total_files))
f.close()


#write thres_freq
f = open('F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\thres_freq_female.txt', 'w+')
f.write((str)(thres_freq))
f.close()



file1 = open("F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\female_graph.txt","a+")
file1.write(sys.argv[1] + "\n")
file1.close()

f = open('F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\min_freq_female.txt', 'r+')
x = f.readlines()
y = (float)(x[0])
if((float)(sys.argv[1]) < y):
    y = (float)(sys.argv[1])

f.close()

f = open('F:\Studies\Sem-3\SignalAndSystems\SAS Project\DataFemale\\min_freq_female.txt', 'w+')
f.write((str)(y))
f.close()