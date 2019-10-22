from win32com.client import constants
import os
import win32com.client
import pythoncom
class SpeechRecognition:
    def __init__(self, wordsToAdd):
        self.speaker = win32com.client.Dispatch("SAPI.SpVoice")
        self.listener = win32com.client.Dispatch("SAPI.SpSharedRecognizer")
        self.context = self.listener.CreateRecoContext()
        self.grammar = self.context.CreateGrammar()
        self.grammar.DictationSetState(0)
        self.wordsRule = self.grammar.Rules.Add("wordsRule", constants.SRATopLevel + constants.SRADynamic, 0)
        self.wordsRule.Clear()
        [self.wordsRule.InitialState.AddWordTransition(None, word) for word in wordsToAdd]
        self.grammar.Rules.Commit()
        self.grammar.CmdSetRuleState("wordsRule", 1)
        self.grammar.Rules.Commit()
        self.eventHandler = ContextEvents(self.context)
        self.say("Started successfully")
    def say(self, phrase):
        self.speaker.Speak(phrase)
class ContextEvents(win32com.client.getevents("SAPI.SpSharedRecoContext")):
    def OnRecognition(self, StreamNumber, StreamPosition, RecognitionType, Result):
        newResult = win32com.client.Dispatch(Result)
        print("小伙子你在说 ", newResult.PhraseInfo.GetText())
        speechstr = newResult.PhraseInfo.GetText()
        if speechstr == "上":
               pass
        elif speechstr == "下":
               pass
        elif speechstr == "左":
               pass
        elif speechstr == "右":
               pass
if __name__  == '__main__':
    wordsToAdd = ["上", "下", "左", "右"]
    speechReco = SpeechRecognition(wordsToAdd)
    while True:
        pythoncom.PumpWaitingMessages()   