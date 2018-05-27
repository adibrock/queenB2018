

class User:
    lastId = -1
    user_list = {}

    def __init__(self, name):
        self.name = name
        self.id = User.lastId + 1
        User.lastId += 1

    def getId(self):
        return str(self.id)