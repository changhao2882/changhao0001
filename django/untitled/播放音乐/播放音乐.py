import pygame
import time

#播放音乐的路径
filePath = r"D:\box\雅俗共赏.mp3"

#初始化
pygame.mixer.init()
#加载音乐
track = pygame.mixer.music.load(filePath)
#播放
pygame.mixer.music.play()
#暂停pygame.mixer.music.pause()
time.sleep(249)
#停止
pygame.mixer.music.stop()