import urllib
import flask
import json
import pickle
app = flask.Flask(__name__)


users_dict = {}

class User:
    lastId = -1


    def __init__(self):
        self.id = str(User.lastId + 1)
        User.lastId += 1
        users_dict[self.id] = self

    def getId(self):
        return self.id

class Goal:

    def __init__(self):
        pass

@app.route('/user/newId')
def make_new_user():
    new_user = User()
    id = new_user.getId()
    str_id = id
    json_user = json.dumps(new_user)
    with open(id, 'w') as f:
        
    return str_id

@app.route("/user/<uid>/edit", methods=['POST'])
def edit_user(uid):
    if flask.request.json is not None and "username" in flask.request.json:
        users_dict[uid].name = flask.request.json["username"]
        return "success"
    else:
        return "something went wrong in edit_user"




if __name__ == "__main__":
    app.run()