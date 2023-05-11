# import re

# def convert_signature(signature):
#     # First, extract the class name and method signature
#     match = re.match(r'<(.+?): (.+)>', signature)
#     class_name = match.group(1)
#     method_signature = match.group(2)

#     # Next, extract the return type and method name
#     match = re.match(r'(\w+) (.+?)\(', method_signature)
import re

def convert_signature(signature):
    # First, extract the class name and method signature
    match = re.match(r'<(.+?):(.+)>', signature)
    if not match:
        "this is not a method signature"
        return signature
    class_name = match.group(1).strip()
    method_signature = match.group(2).strip()
    print(method_signature)
    # Next, extract the return type and method name
    #match = re.match(r'(\w+)\s+(\w+)\(', method_signature)
    match = re.match(r'(.+?)\s+(\w+)\(', method_signature)
    if not match:
        return signature
    return_type = match.group(1)
    method_name = match.group(2)
    print(return_type)
    # Convert the return type to the new format
    if return_type == 'V':
        new_return_type = 'void'
    elif return_type == 'Z':
        new_return_type = 'boolean'
    elif return_type == 'B':
        new_return_type = 'byte'
    elif return_type == 'C':
        new_return_type = 'char'
    elif return_type == 'S':
        new_return_type = 'short'
    elif return_type == 'I':
        new_return_type = 'int'
    elif return_type == 'J':
        new_return_type = 'long'
    elif return_type == 'F':
        new_return_type = 'float'
    elif return_type == 'D':
        new_return_type = 'double'
    else:
        print("test")
        if return_type.startswith('L'):
            new_return_type = return_type[1:].replace('/', '.')
            new_return_type = new_return_type[:-1]
            #new_params.append(param[1:].replace('/', '.'))
        else:
            #new_params.append(param.replace('/', '.'))
            new_return_type = return_type


    # Convert the parameter types to the new format
    params_start_index = method_signature.find('(')
    params_end_index = method_signature.find(')')
    params = method_signature[params_start_index+1:params_end_index]
    new_params = []
    for param in params.split(';'):
        param = param.strip()
        if param:
            if param == 'Z':
                new_params.append('boolean')
            elif param == 'B':
                new_params.append('byte')
            elif param == 'C':
                new_params.append('char')
            elif param == 'S':
                new_params.append('short')
            elif param == 'I':
                new_params.append('int')
            elif param == 'J':
                new_params.append('long')
            elif param == 'F':
                new_params.append('float')
            elif param == 'D':
                new_params.append('double')
            else:
                if param.startswith('L'):
                    new_params.append(param[1:].replace('/', '.'))
                else:
                    new_params.append(param.replace('/', '.'))

    # Combine the new return type and parameter types into the new method signature
    new_method_signature = new_return_type + ' ' + method_name + '(' + ', '.join(new_params) + ')'
    #new_method_signature = new_return_type + ' ' + "tesxcvxcvxcvcxt" + '(' + ', '.join(new_params) + ')'

    # Combine the class name and new method signature into the final result
    return '<' + class_name + ': ' + new_method_signature + '>'

#old_signature = '<com.digitalcosmos.shimeji.mascotselector.MainFragment$2: V onClick(Landroid/view/View;)>'
#old_signature ='<com.digitalcosmos.shimeji.mascot.SpriteUtil: Ljava/util/HashSet; getUsedSprites()>'
#old_signature ='<androidx.appcompat.view.ContextThemeWrapper: Landroid/content/res/AssetManager; getAssets()>'
old_signature ='<com.androidsx.rateme.RateMeDialog$Builder: Lcom/androidsx/rateme/RateMeDialog$Builder; setBodyTextColor(I)>'
new_signature = convert_signature(old_signature)
print(new_signature) # <com.digitalcosmos.shimeji.mascotselector.MainFragment$2: void onClick(android.view.View)>
